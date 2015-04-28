package com.bill.sys.ui.swing.model;

import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.zj.framework.tools.DateUtil;

import com.bill.sys.ui.swing.vos.OrderItemSwingVO;

public class OrderItemTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2051152245054314109L;
	private List<OrderItemSwingVO> items = Collections.emptyList();;
	
	public OrderItemTableModel(List<OrderItemSwingVO> items){
		this.items = items;
	}
	
	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OrderItemSwingVO item = items.get(rowIndex);
		switch(columnIndex){
		case 0:
			return item.getDishName();
		case 1:
			return item.getCount();
		case 2:
			return item.getCountback();
		case 3:
			return item.getPrice();
		case 4:
			return item.getActualAmount();
		case 5:
			return item.getDiscountRate();
		case 6:
			return DateUtil.time2Str(item.getConsumeTime());
		default:
			break;
		}
		return null;
	}

	public void setRowCount(int rowCount){
		int old = getRowCount();
		items = Collections.emptyList();
		if(old > 0){
			super.fireTableRowsDeleted(rowCount,old-1);
		}
	}
}
