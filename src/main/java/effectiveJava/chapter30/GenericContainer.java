package effectiveJava.chapter30;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-12 17:08
 */
@Slf4j
public class GenericContainer {
  // Typesafe heterogeneous container pattern - client
  public static void main(String[] args) {
    Favorites f = new Favorites();
    f.putFavorite(String.class, "Java");
    f.putFavorite(Integer.class, 0xcafebabe);
    f.putFavorite(Class.class, Favorites.class);

    String favoriteString = f.getFavorite(String.class);
    int favoriteInteger = f.getFavorite(Integer.class);
    Class<?> favoriteClass = f.getFavorite(Class.class);
    log.info("{} {} {}", favoriteString, String.format("%x", favoriteInteger),
        favoriteClass.getName());
  }

}

// Typesafe heterogeneous container pattern - implementation
class Favorites {
  private Map<Class<?>, Object> favorites = new HashMap<>();

  public <T> void putFavorite(Class<T> type, T instance) {
    favorites.put(Objects.requireNonNull(type), instance);
  }

  public <T> T getFavorite(Class<T> type) {
    return type.cast(favorites.get(type));
  }
}