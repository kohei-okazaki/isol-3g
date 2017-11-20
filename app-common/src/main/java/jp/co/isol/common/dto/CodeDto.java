package jp.co.isol.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * 定数クラスのDto
 *
 */
@Data
@Entity
@Table(name = "PARAMETER")
public class CodeDto {

	@Column(name = "MAIN_KEY", nullable = false)
	private String mainKey;

	@Column(name = "SUB_KEY", nullable = false)
	private String subKey;

	@Column(name = "VALUE", nullable = false)
	private String value;
}
