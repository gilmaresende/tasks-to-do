package com.condelar.todo.struct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.condelar.todo.app.tools.ToolBase.isNull;

public class BaseController<Entidade extends BaseEntidade,
        Repository extends JpaRepository,
        DTO extends BaseDTO,
        Service extends BaseService<Repository, Entidade, DTO>> {

    @Autowired
    private Service service;

    public Service getService() {
        return service;
    }

    @PostMapping("/save")
    public DTO save(@RequestBody DTO dto) {
        Entidade ob = null;
        if (!isNull(dto.getId())) {
            ob = getService().get(dto.getId());
        } else {
            ob = getService().newOb();
        }
        ob = getService().toOb(dto, ob);
        ob = getService().save(ob);
        dto = getService().toDTO(ob);
        return dto;
    }

}
