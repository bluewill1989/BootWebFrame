import com.wzn.bootwebframe.common.util.FtpUtil2;

def path = args;
log.info("path={}",path);
File file = new File("D:\\ftptest\\"+path);
FtpUtil2.putFileToFtp("ftp://111.231.81.206:21","ftpadmin","ftp","develop","5.txt",file);
return 2;
