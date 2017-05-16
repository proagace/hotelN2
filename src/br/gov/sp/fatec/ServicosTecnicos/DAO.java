/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.ServicosTecnicos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thiago
 * @param <T>
 */
public interface DAO<T> {
    boolean adicionar(T item) throws SQLException;
    boolean remover(T item) throws SQLException;
    T buscar(T item) throws SQLException;
    List<T> listar(String criterio) throws SQLException;
}
