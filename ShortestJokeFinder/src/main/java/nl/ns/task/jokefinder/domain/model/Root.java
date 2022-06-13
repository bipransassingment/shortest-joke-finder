package nl.ns.task.jokefinder.domain.model;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Utility class.
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Root {
  public boolean error;
  public int amount;

  public ArrayList<Jokes> getJokes() {
    return jokes;
  }

  public ArrayList<Jokes> jokes;
}
