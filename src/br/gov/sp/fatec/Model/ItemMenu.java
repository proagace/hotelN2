/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sp.fatec.Model;
import br.gov.sp.fatec.ServicosTecnicos.Messages;
import br.gov.sp.fatec.View.ProdutoView;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Thiago
 */
public class ItemMenu extends JButton implements MouseMotionListener, MouseListener{
    private Produto item;
    private int qtd, origx, origy;
    private Point position = null;
    private Point origem = null;
    
    public ItemMenu(Produto item, Point origem) {
        super(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + File.separator + "images" + File.separator + 
                                item.getImagem()).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        addMouseMotionListener(this);
        addMouseListener(this);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.item = item;
        this.origem = origem;
    }
    
    @Override
    public String toString() {
        return item.getDescricao(); //To change body of generated methods, choose Tools | Templates.
    }   

    @Override
    public void mouseDragged(MouseEvent me) {
        try {
            if (position == null) {
                position = me.getLocationOnScreen();
            }
            int tempx = origem.x + (me.getLocationOnScreen().x - position.x);
            int tempy = origem.y + (me.getLocationOnScreen().y - position.y);
            setLocation(tempx, tempy);
        } catch (NullPointerException e) {
            Messages.showError("Erro inesperado: " + e.getMessage());
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {}

    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {
        Point target = getParent().getComponent(getParent().getComponentCount() -1).getLocation();
        int targetw = getParent().getComponent(getParent().getComponentCount() -1).getWidth();
        int targeth = getParent().getComponent(getParent().getComponentCount() -1).getHeight();
        if (getLocation().x > target.x && getLocation().y > target.y && getLocation().x < (target.x + targetw) && getLocation().y < (target.y + targeth)) {
            ProdutoView.model.addElement(this);
        }
        position = null;
        setLocation(origem);
    }

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
}
