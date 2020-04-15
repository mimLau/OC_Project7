package org.mimi.clibrary.Beans.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormCommand {

        String textField;
        String textareaField;
        String datetimeField;
        String colorField;
        boolean singleCheckboxField;
        List<String> multiCheckboxSelectedValues;
        String checkboxSelectedValue;
        String radioButtonSelectedValue;
        String dropdownSelectedValue;

}
