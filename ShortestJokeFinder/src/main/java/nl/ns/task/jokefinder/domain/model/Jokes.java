package nl.ns.task.jokefinder.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * Utility class.
 */
@NoArgsConstructor
@AllArgsConstructor
public class Jokes extends Root {

  public void setCategory(String category) {
    this.category = category;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setJoke(String joke) {
    this.joke = joke;
  }

  public void setFlags(Flags flags) {
    this.flags = flags;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setSafe(boolean safe) {
    this.safe = safe;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String category;
  public String type;

  public String getCategory() {
    return category;
  }

  public String getType() {
    return type;
  }

  public String getJoke() {
    return joke;
  }

  public int getId() {
    return id;
  }

  public boolean isSafe() {
    return safe;
  }

  public String getLang() {
    return lang;
  }

  public String joke;
  public Flags flags;
  public int id;
  public boolean safe;
  public String lang;


  public Flags getFlags() {
    return flags;
  }
}
