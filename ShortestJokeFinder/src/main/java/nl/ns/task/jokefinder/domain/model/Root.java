package nl.ns.task.jokefinder.domain.model;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.ns.task.jokefinder.model.Joke;

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
