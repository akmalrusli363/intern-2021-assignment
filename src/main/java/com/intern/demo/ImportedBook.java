package com.intern.demo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ImportedBook extends Book {
    private String translator;

    public ImportedBook(String author, String title, String translator) {
        super(author, title);
        this.translator = translator;
    }
}
