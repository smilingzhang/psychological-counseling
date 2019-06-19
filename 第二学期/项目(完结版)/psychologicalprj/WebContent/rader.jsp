<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <style type="text/css">
        #raderGraph{
            width: 320px;
            height: 320px;
        } 
    
    </style>
    <script src="echarts.min.js"></script>
</head>
<body>
    <div id="raderGraph"></div>
    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('raderGraph'));




        var option = {
            title: {
                text: ''
            },
            tooltip: {},
            legend: {
                data: ['预算分配（Allocated Budget）', '实际开销（Actual Spending）']
            },
            radar: {
//                 shape: 'rect',
                name: {
                    textStyle: {
                        color: '#fff',
                        backgroundColor: '#999',
                        borderRadius: 3,
                        padding: [3, 4]
                   }
                },
                indicator: [
                   { name: '知识', max: 100},
                   { name: '品性', max: 100},
                   { name: '能力', max: 100},
                   { name: '技能', max: 100},
                   { name: '身心', max: 100}
                ]
            },
            series: [{
                name: '',
                type: 'radar',
                // areaStyle: {normal: {}},
                data : [
                    
                     {
                        value : [${avgData[1] }, ${avgData[2] }, ${avgData[3] }, ${avgData[4] }, ${avgData[5] }],
                        name : ''
                    }
                ]
            }]
        };



        myChart.setOption(option);
    </script>
</body>
</html>