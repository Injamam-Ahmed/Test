package com.injamam.test.Model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class TestdataUpdateVO extends TestdataVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
