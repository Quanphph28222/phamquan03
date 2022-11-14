/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.KhachHang;
import java.util.List;

/**
 *
 * @author pc
 */
public interface khachHangRepository {

    List<KhachHang> getAll();

    boolean add(KhachHang kh);

    boolean update(String id, KhachHang kh);

    boolean delete(String id);
}
