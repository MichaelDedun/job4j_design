package ru.job4j.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean flag = false;
        Optional<Node<E>> par = this.findBy(parent);
        if (par.isPresent()) {
            Node<E> e = par.get();
            if (!e.children.contains(child)) {
                e.children.add(new Node<>(child));
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean isBinary() {
        Deque<Node> data = new LinkedList<>();
        data.offer(this.root);
        while(!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() <= 2) {
                for (Node<E> node : el.children) {
                    data.offer(node);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

}
