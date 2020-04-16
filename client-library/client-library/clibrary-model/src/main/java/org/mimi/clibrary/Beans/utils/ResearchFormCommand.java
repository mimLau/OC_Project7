package org.mimi.clibrary.Beans.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResearchFormCommand {

        String autorTextField;
        String titleTextField;
        String textareaField;
        String datetimeField;
        String colorField;
        boolean singleCheckboxField;
        List<String> multiCheckboxSelectedValues;
        String checkboxSelectedValue;
        String radioButtonSelectedValue;
        String selectedCat;
        String selectedEdit;

}
