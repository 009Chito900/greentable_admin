package kr.co.greentable.admin.vo;

import java.util.Arrays;

public class ProductVO {

//	String product_name,pro_img_info,pro_img_thumb,product_tooltip,
//			sub_ctg_name,on_sale,pro_text_info;
	String productName, proImgInfoName, proImgThumbName, productTooltip, mainCtg, subCtg, onSale, proTextInfo;
//	List<ProductOptionVO> poVOList;
	String [] productOption = null;
	String [] productPrice = null;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public String getProImgInfoName() {
		return proImgInfoName;
	}

	public void setProImgInfoName(String proImgInfoName) {
		this.proImgInfoName = proImgInfoName;
	}

	public String getProImgThumbName() {
		return proImgThumbName;
	}

	public void setProImgThumbName(String proImgThumbName) {
		this.proImgThumbName = proImgThumbName;
	}

	public String getProductTooltip() {
		return productTooltip;
	}

	public void setProductTooltip(String productTooltip) {
		this.productTooltip = productTooltip;
	}

	public String getSubCtg() {
		return subCtg;
	}

	public void setSubCtg(String subCtg) {
		this.subCtg = subCtg;
	}

	public String getOnSale() {
		return onSale;
	}

	public void setOnSale(String onSale) {
		this.onSale = onSale;
	}

	public String getProTextInfo() {
		return proTextInfo;
	}

	public void setProTextInfo(String proTextInfo) {
		this.proTextInfo = proTextInfo;
	}

	public String[] getProductOption() {
		return productOption;
	}

	public void setProductOption(String[] productOption) {
		this.productOption = productOption;
	}

	public String[] getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String[] productPrice) {
		this.productPrice = productPrice;
	}

	public String getMainCtg() {
		return mainCtg;
	}

	public void setMainCtg(String mainCtg) {
		this.mainCtg = mainCtg;
	}

	@Override
	public String toString() {
		return "ProductVO [productName=" + productName + ", proImgInfoName=" + proImgInfoName + ", proImgThumbName="
				+ proImgThumbName + ", productTooltip=" + productTooltip + ", mainCtg=" + mainCtg + ", subCtg=" + subCtg
				+ ", onSale=" + onSale + ", proTextInfo=" + proTextInfo + ", productOption="
				+ Arrays.toString(productOption) + ", productPrice=" + Arrays.toString(productPrice) + "]";
	}


}
