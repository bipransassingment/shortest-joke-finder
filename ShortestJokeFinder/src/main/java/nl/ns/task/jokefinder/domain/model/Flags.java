package nl.ns.task.jokefinder.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * Utility class.
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flags extends Jokes {
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
