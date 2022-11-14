/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.CTSanPham;
import Viewmodels.CTSanPhamReposton;
import java.util.List;

/**
 *
 * @author pc
 */
public interface CTSanPhamRepostority {

    List<CTSanPhamReposton> getAll();

    CTSanPham getOne(String id);

    boolean add(CTSanPham ctSanPham);

    boolean update(String id, CTSanPham ctSanPham);

    boolean delete(String id);
}
