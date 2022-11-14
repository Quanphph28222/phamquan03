/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.KhachHang;
import java.util.List;

/**
 *
 * @author pc
 */
public interface KhachHangService {

    List<KhachHang> getAll();

    String add(KhachHang kh);

    String update(String id, KhachHang kh);

    String delete(String id);

}
