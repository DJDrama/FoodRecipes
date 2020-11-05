package com.foodrecipes.www.ui.launcher;

import androidx.lifecycle.ViewModel;

import com.foodrecipes.www.Constants;
import com.foodrecipes.www.FoodDataSource;
import com.foodrecipes.www.R;
import com.foodrecipes.www.model.Food;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;

public class SplashScreenViewModel extends ViewModel {

    private final FoodDataSource mDataSource;
    private Food mFood;

    public SplashScreenViewModel(FoodDataSource dataSource) {
        this.mDataSource = dataSource;
    }

    public Completable insertFoodList() {
        List<Food> foodList = getFoodList();
        return mDataSource.insertFoodList(foodList);
    }

    private List<Food> getFoodList() {
        List<Food> foodList = new ArrayList<>();

        // KOREAN FOOD RECIPES
        foodList.add(new Food(
                Constants.KOREAN,
                "배추김치",
                "배추 4포기(7kg)",
                "굵은소금 500g, 무 1kg, 쪽파 300g, 갓 500g, 미나리 4줌(200g), 고춧가루 2컵(200g), 양념(마늘(다진 마늘) 15큰술(150g), 생강(다진 생강) 3큰술(30g), 새우젓 10큰술(10g), 황석어젓 100g, 설탕 2큰술(20g), 찹쌀풀 300g, 소금(소금 약간))",
                "1. 배추는 밑동을 자르고 겉잎을 떼어낸다. 배추 밑동이 위를 향하도록 세우고 밑동 부분의 1/3지점까지 칼집을 내어 양손으로 반을 쪼갠다. 크기에 따라 2~4등분 한다.\n" +
                        "\n" +
                        "2. 큰 볼에 배추를 담고 굵은 소금을 켜켜이 뿌린다. 미지근한 물 4~5컵을 부어 5~6시간 동안 중간중간 뒤집어가며 절인다. 떼어낸 겉잎을 함께 절인다.\n" +
                        "\n" +
                        "3. 절인 배추는 찬물에 2~3번 헹군 후 30분 시간 체에 밭쳐 물기를 뺀다.\n" +
                        "\n" +
                        "4. 무는 껍질을 벗긴 후 0.5cm 두께로 채 썬다. 쪽파, 미나리, 갓은 깨끗이 씻어 체에 밭쳐 물기를 뺀 후 3cm 길이로 썬다.\n" +
                        "\n" +
                        "5. 새우젓은 곱게 다진다.\n" +
                        "\n" +
                        "6. 볼에 무와 고춧가루, 소금을 넣고 버무려 고춧물을 들인다.\n" +
                        "\n" +
                        "7. 6에 양념 재료를 넣고 골고루 버무린 후 미나리, 갓, 쪽파를 넣고 풋내가 나지 않도록 가볍게 버무린다. \n" +
                        "\n" +
                        "8. 양념 볼 위에 절인 배추김치를 올리고 겉잎부터 소를 바르듯이 넣고 켜켜이 펴 바른다.\n" +
                        "\n" +
                        "9. 김치소가 쏟아지지 않도록 잎을 모아 잡고 절인 겉잎으로 감싼다. 저장용기에 차곡차곡 담고 남은 양념에 소금과 물 1컵을 담고 양념을 씻어내 김치 위에 붓는다. 실온에서 하룻동안 숙성한 후 냉장실에서 익혀 먹는다.",
                R.drawable.baechukimchi
        ));
        foodList.add(new Food(
                Constants.KOREAN,
                "총각김치",
                "총각무 2kg, 실파 300g, 갓 300g, 대파(흰부분) 50g, 마늘(다진것) 50g, 생강(다진것) 20g, 소금 65g, 설탕 25g, 멸치젓국 120g, 새우젓 120g, 고춧가루 80g, 찹쌀가루(찹쌀풀) 25g, 물(찹쌀풀) 200ml, 소금(찹쌀풀) 25g",
                null,
                "1. 총각무는 잔털을 떼고 무청 달린 부분의 껍질을 도려 내어 깨끗이 씻고 소금을 고루 뿌려서 절여 물에 살짝 헹궈 소쿠리에 건져 물기를 뺀다.\n" +
                        "\n" +
                        "2. 실파, 갓은 다듬어서 무를 절이는 도중에 함께 넣어 절여서 살짝 씻어 건진다.\n" +
                        "\n" +
                        "3. 대파(흰 부분)는 어슷하게 썬다.\n" +
                        "\n" +
                        "4. 냄비에 물을 담아 찹쌀가루를 잘 풀어서 풀을 쑤어 소금으로 간을 하여 식힌다.\n" +
                        "\n" +
                        "5. 큰 그릇에 멸치젓국을 담아 먼저 고춧가루를 섞고 이어서 식힌 찹쌀풀을 고루 섞은 후에 어슷썬 파, 다진 마늘, 다진 생강, 새우젓, 설탕을 넣어 걸쭉한 양념을 만든다.\n" +
                        "6. 섞어 놓은 양념에 절인 총각무, 실파, 갓을 넣어 고루 버무려서 총각무, 실파, 갓을 두 가닥 정도씩 한 데 모아 말아 둥근 묶음으로 하여 항아리에 차곡차곡 담고 꼭꼭 눌러서 익힌다. 김장철에는 2주 정도면 먹기에 알맞게 익는다. ",
                R.drawable.chongakkimchi
        ));

        return foodList;
    }


}
