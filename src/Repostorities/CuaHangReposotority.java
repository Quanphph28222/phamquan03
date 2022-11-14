/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.CuaHang;
import Repostorities.impl.CuaHangRepostorityImpl;
import Viewmodels.CuaHangResponse;
import java.util.List;

/**
 *
 * @author pc
 */
public interface CuaHangReposotority {

    List<CuaHangResponse> getAll();

    boolean add(CuaHang CuaHang);

    boolean update(String id, CuaHang CuaHang);

    boolean delete(String id);
}
