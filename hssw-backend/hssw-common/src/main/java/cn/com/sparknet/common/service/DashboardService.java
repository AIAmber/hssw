package cn.com.sparknet.common.service;

import cn.com.sparknet.common.json.EditJson;

public interface DashboardService {

    public String jsonLine(String errorType);

    public EditJson savePicture(String userId, String filePath);

    public EditJson fixList(String userId);

    public EditJson hotlineList();

    public EditJson hotlineDetail(String hotlineNo);

    public EditJson insertFixList(String hotlineTitle, String hotlineContent, String fixPerson, String fixPhone, String fixArea, String fixAddr);
}
