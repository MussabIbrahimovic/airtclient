package us.airt.client.core.eventbus;

import us.airt.client.api.event.Event;
import us.airt.client.api.event.EventPriority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public final class EventBus {
    private final List<Listener<? extends Event>> listeners = new CopyOnWriteArrayList<>();

    public <T extends Event> void subscribe(Class<T> eventType, EventPriority priority, Consumer<T> handler) {
        listeners.add(new Listener<>(eventType, priority, handler));
        listeners.sort(Comparator.comparingInt(l -> l.priority.ordinal()));
    }

    @SuppressWarnings("unchecked")
    public <T extends Event> void post(T event) {
        List<Listener<T>> matched = new ArrayList<>();
        for (Listener<? extends Event> listener : listeners) {
            if (listener.eventType.isInstance(event)) {
                matched.add((Listener<T>) listener);
            }
        }

        matched.sort(Comparator.comparingInt(l -> l.priority.ordinal()));
        for (Listener<T> listener : matched) {
            listener.handler.accept(event);
        }
    }

    private record Listener<T extends Event>(Class<T> eventType, EventPriority priority, Consumer<T> handler) {
    }
}
