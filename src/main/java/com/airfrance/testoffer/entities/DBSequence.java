package com.airfrance.testoffer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Entity of DBSequence
 *
 * @author Seifeddine.joo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "db_sequence")
public class DBSequence {

  @Id
  private String id;

  private  int seq;

}
