package jp.co.isol.common.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定数クラスのDto
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PARAMETER")
public class CodeDto implements Serializable {

	/** シリアルバージョンUID */
	private static final Long serialVersionUID = 1L;

	@Column(name = "MAIN_KEY", nullable = false)
	private String mainKey;

	@Column(name = "SUB_KEY", nullable = false)
	private String subKey;

	@Column(name = "VALUE", nullable = false)
	private String value;
}
