package com.github.gsalesc.apialuguelcarros.service.aluguel.validations;

import com.github.gsalesc.apialuguelcarros.domain.aluguel.dto.AluguelNovoDTO;

public interface ValidarAluguel {
	void validarAluguel(AluguelNovoDTO dto);
}
