package kr.co.greentable.admin.service;

import kr.co.greentable.admin.vo.PagingVO;

public class PagingService {
	
	
	public PagingVO setPagingVO(int total, int nowPage, int cntPerPage) {
		PagingVO pgVO = new PagingVO();
		PagingVO pgVO = new PagingVO();
		
		pgVO.setNowPage(nowPage);
		pgVO.setCntPerPage(cntPerPage);
		pgVO.setTotal(total);
		calcLastPage(pgVO.getTotal(), pgVO.getCntPerPage());
		calcStartEndPage(pgVO.getNowPage(), pgVO.cntPage);
		calcStartEnd(pgVO.getNowPage(), pgVO.getCntPerPage());
	}
	// ���� ������ ������ ���
	public void calcLastPage(int total, int cntPerPage) {
		pgVO.setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
	}
	// ����, �� ������ ���
	public void calcStartEndPage(int nowPage, int cntPage) {
		pgVO.setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if (pgVO.getLastPage() < pgVO.getEndPage()) {
			pgVO.setEndPage(pgVO.getLastPage());
		}
		pgVO.setStartPage(pgVO.getEndPage() - cntPage + 1);
		if (pgVO.getStartPage() < 1) {
			pgVO.setStartPage(1);
		}
	}
	// DB �������� ����� start, end�� ���
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
}
