import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Five {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator = new ZipIterator<>(first.iterator(), second.iterator());
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
        return StreamSupport.stream(spliterator, false);
    }

    private static class ZipIterator<T> implements Iterator<T> {
        private final Iterator<T> firstIterator;
        private final Iterator<T> secondIterator;
        private boolean useFirst;

        public ZipIterator(Iterator<T> firstIterator, Iterator<T> secondIterator) {
            this.firstIterator = firstIterator;
            this.secondIterator = secondIterator;
            this.useFirst = true;
        }

        @Override
        public boolean hasNext() {
            return useFirst ? firstIterator.hasNext() : secondIterator.hasNext();
        }

        @Override
        public T next() {
            T element = useFirst ? firstIterator.next() : secondIterator.next();
            useFirst = !useFirst;
            return element;
        }
    }
}