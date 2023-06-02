package model;

import java.util.ArrayList;

public class MusicDAO {
	// 1. 멤버 변수
	private ArrayList<MusicVO> datas;

	// 2. 생성자
	public MusicDAO() {
		datas=Crawling.sample();
	}
	// 3. 메서드
	//3-1. INSERT
	public boolean insert(MusicVO vo) {
		return false;
	}
	//3-2. SELECT ALL
	public ArrayList<MusicVO> selectAll(MusicVO vo) {
		// 전체 출력
		if(vo==null) {
			return this.datas;
		}
		// 이름 검색
		else if (vo.getCnt()== -1) { // 컨트롤 부분에서 약속!
			ArrayList<MusicVO> mdatas = new ArrayList<MusicVO>();
			for(MusicVO data:datas) {
				if(data.getArtist().contains(vo.getArtist()) || data.getTitle().contains(vo.getTitle())) {
					mdatas.add(data);
				}
			}
			return mdatas;
		}
		// 최고 재생횟수 검색
		else if (vo.getNum()== -1) { // 컨트롤 부분에서 약속 
			ArrayList<MusicVO> mdatas = new ArrayList<MusicVO>();
			int max=datas.get(0).getCnt();
			for(int i=1;i<datas.size();i++) {
				if(max<datas.get(i).getCnt()) {
					max=datas.get(i).getCnt();
				}
			}
			if(max!=0) { // 최고 재생횟수가 0일때는 목록 출력 안되게 막기
				for(int i=0;i<datas.size();i++) {
					if(datas.get(i).getCnt()==max) {
						mdatas.add(datas.get(i));
					}
				}
			}
			return mdatas;
		}
		ArrayList<MusicVO> pdatas =new ArrayList<MusicVO>();
		return pdatas;
	}
	//3-3. SELECT ONE
	public MusicVO selectOne(MusicVO vo) {
		for(int i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==vo.getNum()) {
				MusicVO dVO= new MusicVO(datas.get(i).getNum(),datas.get(i).getArtist(),datas.get(i).getTitle(),datas.get(i).getCnt());
				return dVO;
			}
		}
		return null;
	}
	//3-4. UPDATE
	public boolean update(MusicVO vo) {
		if (vo.getArtist().equals("재생") || vo.getArtist().equals("랜덤")) {
			for(int i=0;i<datas.size();i++) { // 배열 사이즈만큼 반복
				if(datas.get(i).getNum()==vo.getNum()) { // 번호 확인
					datas.get(i).setCnt(datas.get(i).getCnt()+1);
					return true;
				}
			}
			return false;
		}
		return false; // 재생,랜덤 거치지 못할 때는 false
	}
	//3-5. DELETE
	public boolean delete(MusicVO vo) {
		return false;
	}








}
