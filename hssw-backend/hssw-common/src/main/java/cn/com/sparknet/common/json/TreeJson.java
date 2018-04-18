package cn.com.sparknet.common.json;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Component;
import cn.com.sparknet.common.bean.AsyncCheckTreeNode;
import cn.com.sparknet.common.bean.AsyncTreeNode;
import cn.com.sparknet.common.bean.SyncCheckTreeNode;
import cn.com.sparknet.common.bean.SyncTreeNode;

/**
 * 树查询时的Json
 * @author chenxy
 *
 */
@Component
public class TreeJson {

	/**
	 * 获取同步Tree的Json（不带选择框）
	 */
	public String getSyncTreeJson(List<SyncTreeNode> list) throws Exception {
		boolean mark = false;
		List<SyncTreeNode> nodeList = new ArrayList<SyncTreeNode>();
		for(SyncTreeNode node1 : list){
		    mark = false;
		    if(hasChildrenForSync(list, node1)){
            	node1.setLeaf("false");
            }else{
            	node1.setLeaf("true");
            }
		    for(SyncTreeNode node2 : list){
		        if(node2.getId().equals(node1.getParentId())){
		            mark = true;
		            if(node2.getChildren() == null){
		            	node2.setChildren(new ArrayList<SyncTreeNode>());
		            }
		            node2.getChildren().add(node1);
		            node2.setLeaf("false");
		            break;
		        }
		    }
		    if(!mark){
		        nodeList.add(node1);
		    }
		}
		return JSONArray.fromObject(nodeList).toString();
	}
	private boolean hasChildrenForSync(List<SyncTreeNode> list, SyncTreeNode node) {
		for(SyncTreeNode chileNode : list){
			if(node.getId().equals(chileNode.getParentId())){
				return true;
			}
		}
		return false;
    }
	
	/**
	 * 获取同步Tree的Json（带选择框）
	 */
	public String getSyncCheckTreeJson(List<SyncCheckTreeNode> list) throws Exception {
		boolean mark = false;
		List<SyncCheckTreeNode> nodeList = new ArrayList<SyncCheckTreeNode>();
		for(SyncCheckTreeNode node1 : list){
		    mark = false;
		    if(hasChildrenForSyncCheck(list, node1)){
            	node1.setLeaf("false");
            }else{
            	node1.setLeaf("true");
            }
		    for(SyncCheckTreeNode node2 : list){
	        	if(node2.getId().equals(node1.getParentId())){
		            mark = true;
		            if(node2.getChildren() == null){
		            	node2.setChildren(new ArrayList<SyncCheckTreeNode>());
		            }
		            node2.getChildren().add(node1);
		            node2.setLeaf("false");
		            break;
		        }
		    }
		    if(!mark){
		        nodeList.add(node1);
		    }
		}
		return JSONArray.fromObject(nodeList).toString();
	}
	private boolean hasChildrenForSyncCheck(List<SyncCheckTreeNode> list, SyncCheckTreeNode node) {
		for(SyncCheckTreeNode chileNode : list){
			if(node.getId().equals(chileNode.getParentId())){
				return true;
			}
		}
		return false;
    }
	

	/**
	 * 获取异步Tree的Json（不带选择框）
	 */
	public String getAsyncTreeJson(List<AsyncTreeNode> list) throws Exception {
		return JSONArray.fromObject(list).toString();
	}
	
	/**
	 * 获取异步Tree的Json（带选择框）
	 */
	public String getAsyncCheckTreeJson(List<AsyncCheckTreeNode> list) throws Exception {
		return JSONArray.fromObject(list).toString();
	}
	
}
