package com.sdg.cmdb.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.ecs.model.v20140526.DescribeImagesResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeInstanceTypesResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeVpcsResponse;
import com.sdg.cmdb.dao.cmdb.ServerDao;
import com.sdg.cmdb.domain.server.EcsServerDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springtest/context.xml"})
public class AliyunServiceImplTest {


    @Resource
    private AliyunServiceImpl aliyunServiceImpl;

    @Resource
    private ServerDao serverDao;




    @Test
    public void testGetDescribeRegions() {
        aliyunServiceImpl.getDescribeRegions();
    }


    @Test
    public void testGetDescribeVpcs() {
        List<DescribeVpcsResponse.Vpc> vpcs = aliyunServiceImpl.getDescribeVpcs();

        for (DescribeVpcsResponse.Vpc vpc : vpcs) {
            System.err.println(vpc.getVpcId());
            // 描述
            System.err.println(vpc.getDescription());
            // 自定义名称
            System.err.println(vpc.getVpcName());

            System.err.println("vSwitchIds:----------------");
            printVSwitchs(vpc.getVSwitchIds());
            System.err.println("vSwitchIds:----------------");
        }
    }

    private void printVSwitchs(List<String> vSwitchIds) {
        for (String id : vSwitchIds)
            System.err.println(id);
    }

    @Test
    public void testRsyncAliyunNetwork() {
        System.err.println(aliyunServiceImpl.rsyncAliyunNetwork());
    }


    @Test
    public void testGetImages() {
        List<DescribeImagesResponse.Image> list = aliyunServiceImpl.getImages();
        for(DescribeImagesResponse.Image image:list){
            System.err.println(JSON.toJSONString(image));
        }
    }

    @Test
    public void testDescribeInstanceTypes() {
        List<DescribeInstanceTypesResponse.InstanceType> list = aliyunServiceImpl.getInstanceTypes(null);
        for (DescribeInstanceTypesResponse.InstanceType type : list) {
            System.err.println("=============================");
            System.err.println(type.getCpuCoreCount());
            System.err.println(type.getInstanceTypeFamily());
            System.err.println(type.getInstanceTypeId());
            System.err.println(type.getMemorySize());
            System.err.println("-----------------------------");
        }
    }

}
