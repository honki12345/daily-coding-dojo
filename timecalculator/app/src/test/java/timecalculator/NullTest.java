package timecalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NullTest {

    class Entity {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Dto {

        private String name;

        public Dto(Entity entity) {
            this.name = entity.getName();
        }

        public String getName() {
            return name;
        }
    }

    @Test
    void test() {
        // given
        Entity entity = new Entity();
        entity.setName(null);

        // when // then
        Assertions.assertDoesNotThrow(() -> new Dto(entity));
    }
}