/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.Nsx;
import java.util.List;

/**
 *
 * @author pc
 */
public interface NSXRepostority {

    List<Nsx> getAll();

    boolean addNsx(Nsx nsx);

    boolean deleteNsx(Nsx nsx);

    boolean updateNsx(Nsx nsx);

}
