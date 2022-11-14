/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author pc
 */
public interface NhanVienService {

    List<NhanVien> getAll();

    String add(NhanVien nv);

    String update(String id, NhanVien nv);

    String delete(String id);
}
