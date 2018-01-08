package com.guedim.consul.discovery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pricing")
public class PricingEndpoint implements InitializingBean {
  @Autowired
  DiscoveryClient client;
  Map<String, Double> pricingMap = new HashMap<>();

  RestTemplate restTemplate = new RestTemplate();

  @ApiOperation(value = "Retrieves a fully priced portfolio",
      notes = "Retrieves fully priced portfolio given customer id and portfolio id")
  @GetMapping("/customer/{customer-id}/portfolio/{portfolio-id}")
  public List<String> getPricedPortfolio(@PathVariable("customer-id") Integer customerId,
      @PathVariable("portfolio-id") Integer portfolioId) {
    List<ServiceInstance> instances = client.getInstances("portfolio-service");
    ServiceInstance instance =
        instances.stream().findFirst().orElseThrow(() -> new RuntimeException("not found"));
    String url = String.format("%s/portfolios/customer/%d/portfolio/%d", instance.getUri(),
        customerId, portfolioId);
    // query for the portfolios, returned as an array of List
    // of size 2, containing a ticker and a position (# of shares)
    Object[] portfolio = restTemplate.getForObject(url, Object[].class);
    // Look up the share prices, and return a list of Strings, formatted as
    // ticker, shares, price, total
    List<String> collect = Arrays.stream(portfolio).map(position -> {
      String ticker = ((List<String>) position).get(0);
      int shares = ((List<Integer>) position).get(1);
      double price = getPrice(ticker);
      double total = shares * price;
      return String.format("%s %d %f %f", ticker, shares, price, total);
    }).collect(Collectors.toList());
    return collect;
  }

  private double getPrice(String ticker) {
    return pricingMap.get(ticker);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    pricingMap.put("MMM", 201.81);
    pricingMap.put("AXP", 85.11);
    pricingMap.put("AAPL", 161.04);
    pricingMap.put("BA", 236.32);
    pricingMap.put("CAT", 118.02);
    pricingMap.put("CVX", 111.31);
    pricingMap.put("CSCO", 31.7);
    pricingMap.put("KO", 46.00);
    pricingMap.put("DIS", 101.92);
    pricingMap.put("XOM", 78.7);
    pricingMap.put("GE", 24.9);
    pricingMap.put("GS", 217.62);
    pricingMap.put("HD", 155.82);
    pricingMap.put("IBM", 144.29);
    pricingMap.put("INTC", 35.66);
    pricingMap.put("JNJ", 130.8);
    pricingMap.put("JPM", 89.75);
    pricingMap.put("MCD", 159.81);
    pricingMap.put("MRK", 63.89);
    pricingMap.put("MSFT", 73.65);
    pricingMap.put("NKE", 52.78);
    pricingMap.put("PFE", 33.92);
    pricingMap.put("PG", 92.79);
    pricingMap.put("TRV", 117.00);
    pricingMap.put("UTX", 110.12);
    pricingMap.put("UNH", 198.00);
    pricingMap.put("VZ", 47.05);
    pricingMap.put("V", 103.34);
    pricingMap.put("WMT", 80.05);

  }
}
