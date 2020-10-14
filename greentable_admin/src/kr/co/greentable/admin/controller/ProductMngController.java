package kr.co.greentable.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.greentable.admin.domain.ProductDomain;
import kr.co.greentable.admin.service.ProductService;
import kr.co.greentable.admin.vo.ProductVO;
import kr.co.greentable.admin.vo.UpdateProductVO;

@Controller
public class ProductMngController {
	
	@GetMapping("/product_mng_list.do")
	public String productList(Model model) {
		
		model.addAttribute("pdList", new ProductService().allList());
		
		model.addAttribute("mainCtgList", new ProductService().mainCategory());
		
		return "/product/product_mng_list";
	}
	
	@GetMapping("/product_mng_detail.do")//�̾��� 1007 16:48
	public String productDetail(String productNum,Model model ) {
		List<ProductDomain> pddList = new ProductService().allList();
		String[] onSaleArr = {"Y","N"};
		for(ProductDomain pdd : pddList) {
			if(productNum.trim().equals(pdd.getProduct_num().trim())) {
				model.addAttribute("pdd", pdd);
				model.addAttribute("subCtgList", new ProductService().subCategory(pdd.getMain_ctg_name()));
				model.addAttribute("onSaleArr", onSaleArr);
			}
		}
		model.addAttribute("mainCtgList", new ProductService().mainCategory());
		return "/product/product_mng_detail_frm";
	}
	
//	@GetMapping("/product_img_frm.do")
//	public String productImgFrm() {
//		
//		return "/product/product_img_frm";
//	}
	
	@GetMapping("/product_mng_frm.do")
	public String productRg() {
		
		return "/product/product_mng_frm";
	}
	
	
	@PostMapping("/product_process.do")
	public String productRegistration(HttpServletRequest request, Model model) throws IOException {
		ProductService pds = new ProductService();
		
		String path="C:/Users/sist/git/greentable_admin/greentable_admin/WebContent/upload_img"; 
		int maxSize=1024*10124*20;
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		ProductVO pdVO = new ProductVO();
		pdVO.setProductName(mr.getParameter("productName"));
		pdVO.setProImgInfoName(mr.getParameter("proImgInfoName"));
		pdVO.setProImgThumbName(mr.getParameter("proImgThumbName"));
		pdVO.setProductTooltip(mr.getParameter("productTooltip"));
		pdVO.setMainCtg(mr.getParameter("mainCtg"));
		pdVO.setSubCtg(mr.getParameter("subCtg"));
		pdVO.setOnSale(mr.getParameter("onSale"));
		pdVO.setProTextInfo(mr.getParameter("proTextInfo"));
		pdVO.setProductOption(mr.getParameterValues("productOption"));
		pdVO.setProductPrice(mr.getParameterValues("productPrice"));
		
		String msg = pds.insertAll(pdVO) == false? "상품 등록이 실패되었습니다.." : "상품 등록이 성공하였습니다."; 
		model.addAttribute("productMsg", msg);
		return "/product/product_result";
	}
	
	@PostMapping("/product_mnr.do")
	public String delProduct(HttpServletRequest request, Model model) throws IOException {
		String msg = "";
		ProductService pds = new ProductService();
		
		String path="C:/Users/sist/git/greentable_admin/greentable_admin/WebContent/upload_img"; 
		int maxSize=1024*10124*20;
		MultipartRequest mr=new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		UpdateProductVO udpdVO = new UpdateProductVO();
		udpdVO.setProductNum(mr.getParameter("productNum"));
		udpdVO.setProductName(mr.getParameter("productName"));
		udpdVO.setProImgInfoName(mr.getParameter("proImgInfoName"));
		udpdVO.setProImgThumbName(mr.getParameter("proImgThumbName"));
		udpdVO.setProductTooltip(mr.getParameter("productTooltip"));
		udpdVO.setMainCtg(mr.getParameter("mainCtg"));
		udpdVO.setSubCtg(mr.getParameter("subCtg"));
		udpdVO.setOnSale(mr.getParameter("onSale"));
		udpdVO.setProTextInfo(mr.getParameter("proTextInfo"));
		udpdVO.setProductOption(mr.getParameterValues("productOption"));
		udpdVO.setProductPrice(mr.getParameterValues("productPrice"));
		System.out.println(udpdVO.toString());
		System.out.println(mr.getParameter("mdFlag"));
		if("del".equals(mr.getParameter("mdFlag"))) {
			msg = pds.deleteProduct(udpdVO.getProductNum()) == false?"상품 삭제 실패하였습니다." : "상품 삭제 성공하였습니다.";
		}
		if("modi".equals(mr.getParameter("mdFlag"))) {
			
			msg = pds.updateAll(udpdVO) == false?"상품 수정 실패하였습니다." : "상품 수정 성공하였습니다.";
		}
		model.addAttribute("productMsg", msg);

		return "product/product_result";
	}
}
