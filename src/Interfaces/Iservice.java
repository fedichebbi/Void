/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.EntityBabySitter;
import java.util.List;

/**
 *
 * @author benka
 */
public interface Iservice <T,R> {
     List<T> getAll();
    
}
