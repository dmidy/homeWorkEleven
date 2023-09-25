import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Four {
    public static Stream<Long> generateRandomStream(long a, long c, long m, long seed) {
        Iterator<Long> iterator = new RandomIterator(a, c, m, seed);
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
    }

    private static class RandomIterator implements Iterator<Long> {
        private final long a;
        private final long c;
        private final long m;
        private long current;

        public RandomIterator(long a, long c, long m, long seed) {
            this.a = a;
            this.c = c;
            this.m = m;
            this.current = seed;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Long next() {
            long nextValue = (a * current + c) % m;
            current = nextValue;
            return nextValue;
        }
    }
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 12345L;

        Stream<Long> randomStream = generateRandomStream(a, c, m, seed);
        randomStream.limit(10).forEach(System.out::println);
    }
}
