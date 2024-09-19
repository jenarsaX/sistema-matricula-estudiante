package LAL;

import MODELO.Alumno;
import MODELO.Apoderado;
import MODELO.Docente;
import MODELO.Matricula;
import MODELO.Seccion;

public class ListaEnlazada {

    // A generic Node class to hold data of any type
    private class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<Alumno> headAlumno;
    private Node<Docente> headDocente;
    private Node<Matricula> headMatricula;
    private Node<Apoderado> headApoderado;
    private Node<Seccion> headSeccion;

    // Constructor for the linked list
    public ListaEnlazada() {
        this.headAlumno = null;
        this.headDocente = null;
        this.headMatricula = null;
        this.headApoderado = null;
        this.headSeccion = null;
    }

    // Method to add a new Alumno
    public void addAlumno(Alumno alumno) {
        Node<Alumno> newNode = new Node<>(alumno);
        newNode.next = headAlumno;
        headAlumno = newNode;
    }

    // Method to add a new Docente
    public void addDocente(Docente docente) {
        Node<Docente> newNode = new Node<>(docente);
        newNode.next = headDocente;
        headDocente = newNode;
    }

    // Method to add a new Matricula
    public void addMatricula(Matricula matricula) {
        Node<Matricula> newNode = new Node<>(matricula);
        newNode.next = headMatricula;
        headMatricula = newNode;
    }

    // Method to add a new Apoderado
    public void addApoderado(Apoderado apoderado) {
        Node<Apoderado> newNode = new Node<>(apoderado);
        newNode.next = headApoderado;
        headApoderado = newNode;
    }

    // Method to add a new Seccion
    public void addSeccion(Seccion seccion) {
        Node<Seccion> newNode = new Node<>(seccion);
        newNode.next = headSeccion;
        headSeccion = newNode;
    }

    // Additional methods can be added for other operations like delete, find, etc.
}
