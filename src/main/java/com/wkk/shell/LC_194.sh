#给定一个文件 file.txt，转置它的内容。
#
#你可以假设每行列数相同，并且每个字段由 ' ' 分隔。
column=$(awk '{print NF}' file.txt | uniq)
for((i=1;i<=column;i++))
do
  cut -d' ' -f$i file.txt|xargs
done