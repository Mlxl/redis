package model;
//�ҵ�redis ��Ⱥ�е�����key
import java.util.ArrayList;
import java.util.List;


import redis.clients.jedis.Jedis;
//key�����
public class Keys {
	//�洢���е�keys��Ϣ
	private List<String> keysname=new ArrayList<String>();
	
	@SuppressWarnings("rawtypes")
	private  List<List> master=new ArrayList<List>();
	public Keys(){
		
		searchMaster();
		searchKeys();
	}
	
	
	//��ȡ�������ڵ�
	private void searchMaster(){
		for(int i=0;i<CollectData.info.size();i++){
			if(CollectData.info.get(i).getRoles().startsWith("��")){
				List<String> l=new ArrayList<String>();
				l.add(CollectData.info.get(i).getIP());
				l.add(CollectData.info.get(i).getPort());
				master.add(l);
			}
		}
	}
	
	//��ȡ����key��
	private void searchKeys(){
		for(int i=0;i<master.size();i++){
			Jedis jedis=new Jedis(master.get(i).get(0).toString(),Integer.parseInt(master.get(i).get(1).toString()));
			Object [] o=jedis.keys("*").toArray();
			for(int s=0;s<o.length;s++){
				keysname.add(o[s].toString());
			}
			try{
				jedis.close();
			}catch(Exception e){
				System.out.println("jedis�ر�ʧ��");
			}
		}
	}
	
	public List<String> getKeysName(){
		return this.keysname;
	}
	
	//����key����������
	public String getKeyType(String s){
		if(!this.keysname.contains(s)) return null;
		return Connect.cluster.type(s);
		
	}
}










