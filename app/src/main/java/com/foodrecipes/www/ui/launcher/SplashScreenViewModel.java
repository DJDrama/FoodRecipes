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
                Constants.KOREAN_KIMCHI,
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
                Constants.KOREAN_KIMCHI,
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
        foodList.add(new Food(
                Constants.KOREAN,
                Constants.KOREAN_KIMCHI,
                "파김치",
                "쪽파 3kg, 고춧가루 1과 1/2컵(150g)",
                "양파 3/4개(150g), 홍고추 2개(20g), 소금 3큰술(30g), 찹쌀풀 400g, 멸치액젓 2컵(400ml), 마늘(다진 마늘) 10큰술(100g), 생강(다진 생강) 2큰술(20g), 설탕 5큰술(50g)",
                "1. 쪽파는 뿌리 부분을 자르고 지저분한 겉 껍질을 벗긴다. 흙이 남아있지 않도록 물에 담가 깨끗이 씻는다. 볼에 소금과 물을 넣고 쪽파를 넣고 숨이 죽을 때까지 절인 후 체에 밭쳐 물기를 뺀다.(절이는 시간 약 30분~1시간)\n" +
                        "\n" +
                        "2. 양파는 채 썰고, 홍고추는 반으로 갈라 씨를 빼고 채 썬다.\n" +
                        "\n" +
                        "3. 볼에 찹쌀풀, 멸치액젓, 다진 마늘, 다진 생강, 고춧가루, 설탕을 섞어 양념을 만든다.\n" +
                        "\n" +
                        "4. 양념에 쪽파, 양파, 홍고추를 넣고 골고루 버무린다. 실온에서 하루 동안 숙성 시킨 후 냉장실에 넣고 익혀 먹는다.",
                R.drawable.pakimchi
        ));
        foodList.add(new Food(
                Constants.KOREAN,
                Constants.KOREAN_KIMCHI,
                "깍두기",
                "무 3kg",
                "갓 200g, 쪽파 10줄기(100g), 양파 3/4개(150g), 고춧가루 1컵(100g), 양념(멸치액젓 5큰술(75ml), 새우젓 5큰술(50g), 대파(다진 대파) 2큰술(20g), 마늘(다진 마늘) 8큰술(80g), 생강(다진 생강) 2큰술(20g), 소금 2큰술(20g), 설탕 4큰술(40g))",
                "1. 무는 껍질을 벗긴 후 사방 2cm 크기로 깍둑 썬다. \n" +
                        "\n" +
                        "2. 쪽파, 갓은 깨끗이 씻은 후 2cm 길이로 썰고, 양파는 채 썬다. 새우젓은 곱게 다진다.\n" +
                        "\n" +
                        "3. 큰 볼에 무와 고춧가루를 넣고 골고루 버무려 색을 낸다. \n" +
                        "\n" +
                        "4. 3에 쪽파, 갓, 양념 재료를 넣어 골고루 버무린다. 실온에서 하루 동안 숙성시킨 후 냉장실에서 익혀 먹는다.",
                R.drawable.kakdugi
        ));
        foodList.add(new Food(
                Constants.KOREAN,
                Constants.KOREAN_SOUP,
                "된장찌개",
                "된장(시판용 된장) 2큰술(20g), 멸치(국물용 멸치) 20마리(20g), 물 3컵(600ml), 고춧가루 약간, 무 35g, 청양고추 1개(10g), 애호박 1/9개(30g), 두부 50g, 팽이버섯 20g",
                "대파 5cm(10g), 마늘(다진 마늘) 1/2큰술(5g)",
                "1. 냄비에 국물용 멸치와 물을 넣고 한소끔 끓여 체에 걸러 멸치 육수를 2컵(400ml)을 만든다.(국물용 멸치의 머리와 내장은 떼어내면 멸치 육수의 쓴맛이 없어진다.) 무는 사방 3cm 크기로 납작하게 썬다. 두부는 사방 2cm 크기로 깍뚝 썰고 애호박은 0.5cm 두께로 4등분한다. 청양고추와 대파는 송송 썬다. 팽이버섯은 밑동을 제거한 후 가닥가닥 뜯는다.\n" +
                        "\n" +
                        "2. 냄비에 멸치 국물을 붓고 체에 된장을 올려 풀어준다. \n" +
                        "\n" +
                        "3. 무를 넣고 푹 익도록 끓인다.\n" +
                        "\n" +
                        "4. 애호박, 두부, 청양고추, 대파, 팽이버섯, 고춧가루를 넣고 한소끔 끓인다.(중간 중간에 떠오르는 거품을 걷어낸다.)",
                R.drawable.donjang
        ));
        foodList.add(new Food(
                Constants.KOREAN,
                Constants.KOREAN_SOUP,
                "김치찌개",
                "돼지고기(앞다리살 또는 목살) 300g, 배추김치 1/4포기, 두부 1/2모, 대파 1/2대, 다시마 멸치물 3컵, 고춧가루 1큰술, 김치국물 1/2컵",
                "맛술 2큰술, 다진마늘 1작은술, 소금 1/4작은술, 생강가루 약간, 후추 약간",
                "1. 돼지고기는 먹기 좋게 썰어 고기양념에 밑간하여 15분 정도 재워준다.\n" +
                        "\n" +
                        "2. 배추김치와 두부는 먹기 좋게 썰고, 대파는 어슷하게 썰어 준다. \n" +
                        "\n" +
                        "3. 냄비에 약간의 기름을 두르고 돼지고기를 넣어 2분 정도 볶아 표면이 살짝 익으면, 김치를 넣어 3~4분 정도 더 볶아준 후 국물재료 넣어 15분 정도 끓여준다. \n" +
                        "\n" +
                        "4. 두부와 대파를 넣고 2분 정도 더 끓이다가 불을 끈다.",
                R.drawable.kimchisoup
        ));
        return foodList;
    }


}
