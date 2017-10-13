package jp.co.isol.manage.view;

import java.util.ArrayList;
import java.util.List;

import jp.co.isol.common.message.Message;
import jp.co.isol.manage.dto.UserInfoDto;
import lombok.Getter;

/**
 * @author kou1210hei<br>
 * ダウンロードするファイルの文言を設定するクラス
 *
 */
public class FileMessage {

	@Getter
	private List<String> messageList;

	public FileMessage() {
		messageList = new ArrayList<String>();
	}

	public void setFileMessageList(UserInfoDto dto) {
		messageList.add("計算結果");
		messageList.add(Message.HEIGHT.getName() + " : " + dto.getHeight());
		messageList.add(Message.WEIGHT.getName() + " : " + dto.getWeight());
		messageList.add(Message.BMI.getName() + " : " + dto.getBmi());
		messageList.add(Message.STANDARDWEIGHT.getName() + " : " + dto.getStandardWeight());
	}

}
