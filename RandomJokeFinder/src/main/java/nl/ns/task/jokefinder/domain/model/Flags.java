package nl.ns.task.jokefinder.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.ns.task.jokefinder.model.Joke;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flags extends Joke {
  public boolean nsfw;
  public boolean religious;
  public boolean political;

  public boolean isNsfw() {
    return nsfw;
  }

  public boolean isReligious() {
    return religious;
  }

  public boolean isPolitical() {
    return political;
  }

  public boolean isRacist() {
    return racist;
  }

  public boolean isSexist() {
    return sexist;
  }

  public boolean isExplicit() {
    return explicit;
  }

  public boolean racist;
  public boolean sexist;
  public boolean explicit;
}
