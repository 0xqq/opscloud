package com.sdg.cmdb.controller;

import com.sdg.cmdb.domain.HttpResult;
import com.sdg.cmdb.service.CiService;
import com.sdg.cmdb.service.ServerCostService;
import com.sdg.cmdb.service.ServerPerfService;
import com.sdg.cmdb.service.ServerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by liangjian on 2017/2/17.
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @Resource
    private ServerCostService serverCostService;

    @Resource
    private ServerPerfService serverPerfService;




    @RequestMapping(value = "/servercost/page", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult queryServercostPage(@RequestParam int year, @RequestParam int month) {
        return new HttpResult(serverCostService.getServerPage(year, month));
    }

    @RequestMapping(value = "/servercost/statistics", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult serverCostStatistics(@RequestParam int year, @RequestParam int month) {
        return new HttpResult(serverCostService.statistics(year, month));
    }


    @RequestMapping(value = "/serverperf/page", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult queryServerPage(@RequestParam long serverGroupId, @RequestParam String serverName,
                                      @RequestParam int useType, @RequestParam int envType, @RequestParam String queryIp,
                                      @RequestParam int page, @RequestParam int length) {
        return new HttpResult(serverPerfService.getServerPerfPage(serverGroupId, serverName, useType, envType, queryIp, page, length));
    }

    @RequestMapping(value = "/serverperf/statistics", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult serverPerfStatistics() {
        return new HttpResult(serverPerfService.statistics());
    }

    @RequestMapping(value = "/serverperf/task/get", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult serverPerfTaskGet() {
        return new HttpResult(serverPerfService.taskGet());
    }

    @RequestMapping(value = "/serverperf/task/reset", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult serverPerfTaskReset() {
        return new HttpResult(serverPerfService.taskReset());
    }

    @RequestMapping(value = "/serverperf/task/run", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult serverPerfTaskRun() {
        return new HttpResult(serverPerfService.taskRun());
    }


}
