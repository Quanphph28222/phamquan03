/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ChucVuRepostority {

    List<ChucVu> getAll();

    ChucVu getOne(String id);

    boolean add(ChucVu chucVu);

    boolean update(String id, ChucVu chucVu);

    boolean delete(String id);
}
