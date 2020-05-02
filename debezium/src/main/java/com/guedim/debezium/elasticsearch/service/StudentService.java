package com.guedim.debezium.elasticsearch.service;

import static com.guedim.debezium.utils.Constant.INDEX;
import static com.guedim.debezium.utils.Constant.TYPE;

import java.io.IOException;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guedim.debezium.elasticsearch.model.Student;
import com.guedim.debezium.elasticsearch.repository.StudentRepository;
import com.guedim.debezium.utils.Operation;

@Service
public class StudentService {

	/**
	 * Handle to ElasticSearch
	 */
	private final RestHighLevelClient client;

	@Autowired
	public StudentService(StudentRepository studentRepository, RestHighLevelClient client) {
		this.client = client;
	}

	/**
	 * Updates/Inserts/Delete student data.
	 *
	 * @param studentData
	 * @param operation
	 * @throws IOException
	 */
	public void maintainReadModel(Map<String, Object> studentData, Operation operation) {

		switch (operation) {
		case CREATE:
			create(studentData);
			break;
		case UPDATE:
			update(studentData);
			break;
		case DELETE:
			delete(studentData);
			break;
		default:
			break;
		}
	}

	private void create(Map<String, Object> studentData) {
		IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, getStudenId(studentData)).source(studentData,
				XContentType.JSON);
		try {
			client.index(indexRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void update(Map<String, Object> studentData) {
		try {
			Student student = findById(getStudenId(studentData));
			UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, student.getId());
			updateRequest.doc(studentData);
			client.update(updateRequest, RequestOptions.DEFAULT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void delete(Map<String, Object> studentData) {
		DeleteRequest deleteRequest = new DeleteRequest(INDEX, TYPE, getStudenId(studentData));
		try {
			client.delete(deleteRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Student findById(String id) throws Exception {
		GetRequest getRequest = new GetRequest(INDEX, TYPE, id);
		GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
		Map<String, Object> resultMap = getResponse.getSource();
		return convertMapToStudent(resultMap);
	}

	private Student convertMapToStudent(Map<String, Object> map) {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(map, Student.class);
	}

	private String getStudenId(Map<String, Object> map) {
		return (String) map.get("id");
	}
}
