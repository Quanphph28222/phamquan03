/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author pc
 */
public interface NhanhVienRepository {

    List<NhanVien> getAll();

    boolean add(NhanVien nv);

    boolean update(String id, NhanVien nv);

    boolean delete(String id);
}
