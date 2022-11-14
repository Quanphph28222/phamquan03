/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author pc
 */
public interface MauSacRepoStority {
    List<MauSac> getAll();
    
    boolean addMau(MauSac mau);
    
    boolean deleteMau(MauSac mau);
    
    boolean updateMau(MauSac mau);
}
