package com.mingxin.comment.controller;

/**
 * 
 * @Title: fileUp
 * @Description:wangEditor上传图片
 * @param
 * @return
 */
@RequestMapping("/fileUp")
@ResponseBody
public AjaxJson fileUp(HttpServletRequest request){
    AjaxJson j = new AjaxJson();
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    try {
        multipartRequest.setCharacterEncoding("UTF-8");
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        // 文件数据库保存的路径
        String path = null;
        // 文件保存在硬盘的相对路径
        String realPath = null;

        realPath = ResourceUtil.getConfigByName("webUploadpath") + "/";
        path = ResourceUtil.getConfigByName("http_url") + "/";
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();// 创建根目录
        }
        realPath += DateUtils.getDataString(DateUtils.yyyyMMdd) + "/";
        path += DateUtils.getDataString(DateUtils.yyyyMMdd) + "/";
        file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();// 创建文件时间子目录
        }
        String fileName = "";
        // String swfName = "";
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {

            MultipartFile mf = entity.getValue();// 获取上传文件对象
            fileName = mf.getOriginalFilename();// 获取文件名
            // swfName =
            // PinyinUtil.getPinYinHeadChar(oConvertUtils.replaceBlank(FileUtils.getFilePrefix(fileName)));//
            // 取文件名首字母作为SWF文件名
            String extend = FileUtils.getExtend(fileName);// 获取文件扩展名
            String myfilename = "";
            String noextfilename = "";// 不带扩展名

            noextfilename = DateUtils.getDataString(DateUtils.yyyymmddhhmmss) + StringUtil.random(8);// 自定义文件名称
            myfilename = noextfilename + "." + extend;// 自定义文件名称

            String savePath = realPath + myfilename;// 文件保存全路径

            File savefile = new File(savePath);
            if (entity.getKey() != null) {
                // 设置文件数据库的物理路径
                String filePath = path + myfilename;
                j.setObj(filePath);
            }
            // 文件拷贝到指定硬盘目录
            if ("txt".equals(extend)) {
                // 利用utf-8字符集的固定首行隐藏编码原理
                // Unicode:FF FE UTF-8:EF BB
                byte[] allbytes = mf.getBytes();
                try {
                    String head1 = toHexString(allbytes[0]);
                    // System.out.println(head1);
                    String head2 = toHexString(allbytes[1]);
                    // System.out.println(head2);
                    if ("ef".equals(head1) && "bb".equals(head2)) {
                        // UTF-8
                        String contents = new String(mf.getBytes(), "UTF-8");
                        if (StringUtils.isNotBlank(contents)) {
                            OutputStream out = new FileOutputStream(savePath);
                            out.write(contents.getBytes());
                            out.close();
                        }
                    } else {

                        // GBK
                        String contents = new String(mf.getBytes(), "GBK");
                        OutputStream out = new FileOutputStream(savePath);
                        out.write(contents.getBytes());
                        out.close();
                    }
                } catch (Exception e) {
                    String contents = new String(mf.getBytes(), "UTF-8");
                    if (StringUtils.isNotBlank(contents)) {
                        OutputStream out = new FileOutputStream(savePath);
                        out.write(contents.getBytes());
                        out.close();
                    }
                }
            } else {
                FileCopyUtils.copy(mf.getBytes(), savefile);
            }
        }
    } catch (Exception e) {
        j.setSuccess(false);
        e.printStackTrace();
    }
    return j;
}

private String toHexString(int index) {
    String hexString = Integer.toHexString(index);
    // 1个byte变成16进制的，只需要2位就可以表示了，取后面两位，去掉前面的符号填充
    hexString = hexString.substring(hexString.length() - 2);
    return hexString;
}
