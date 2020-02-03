package com.payulatam.pmequalizer.services;

import com.payulatam.pmequalizer.model.PmEqualizer;

public interface IEqualizeService {
    PmEqualizer intializeSingleEqualize(int accountId);

	void confirmPmEqualizer(Integer accountId);
}
