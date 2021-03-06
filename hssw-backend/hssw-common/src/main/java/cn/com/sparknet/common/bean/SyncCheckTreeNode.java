package cn.com.sparknet.common.bean;

import java.util.List;

import cn.com.sparknet.common.util.StringUtil;

/**
 * 同步树节点（带选择框）
 * @author chenxy
 *
 */
public class SyncCheckTreeNode {
	
	private String id;
	
    private String text;
    
    private String parentId;
    
    private boolean expanded;
    
    private boolean checked;
    
    private boolean leaf;
    
    private String iconCls;
    
    private String url;
    
    private String ord;
    
    private String other1;
    
    private String other2;
    
    private String other3;
    
    private List<SyncCheckTreeNode> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(String expanded) {
		if(StringUtil.isNotEmpty(expanded)){
			if(expanded.equals("true")){
				this.expanded = true;
			}else{
				this.expanded = false;
			}
		}else{
			this.expanded = false;
		}
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		if(StringUtil.isNotEmpty(checked)){
			if(checked.equals("true")){
				this.checked = true;
			}else{
				this.checked = false;
			}
		}else{
			this.checked = false;
		}
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		if(StringUtil.isNotEmpty(leaf)){
			if(leaf.equals("true")){
				this.leaf = true;
			}else{
				this.leaf = false;
			}
		}else{
			this.leaf = false;
		}
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOrd() {
		return ord;
	}

	public void setOrd(String ord) {
		this.ord = ord;
	}

	public List<SyncCheckTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<SyncCheckTreeNode> children) {
		this.children = children;
	}

	public String getOther1() {
		return other1;
	}

	public void setOther1(String other1) {
		this.other1 = other1;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}

	public String getOther3() {
		return other3;
	}

	public void setOther3(String other3) {
		this.other3 = other3;
	}

}
