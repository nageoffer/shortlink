import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nageoffer.shortlink.project.common.biz.user.UserContext;
import com.nageoffer.shortlink.project.common.convention.exception.ServiceException;
import com.nageoffer.shortlink.project.dao.entity.*;
import com.nageoffer.shortlink.project.dao.mapper.*;
import com.nageoffer.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.nageoffer.shortlink.project.dto.resp.*;
import com.nageoffer.shortlink.project.service.impl.ShortLinkStatsServiceImpl;

@ExtendWith(MockitoExtension.class)
class ShortLinkStatsServiceImplTest {

    @InjectMocks
    private ShortLinkStatsServiceImpl shortLinkStatsService;

    @Mock
    private LinkGroupMapper linkGroupMapper;

    @Mock
    private LinkAccessStatsMapper linkAccessStatsMapper;

    @Mock
    private LinkLocaleStatsMapper linkLocaleStatsMapper;

    @Mock
    private LinkAccessLogsMapper linkAccessLogsMapper;

    @Mock
    private LinkBrowserStatsMapper linkBrowserStatsMapper;

    @Mock
    private LinkOsStatsMapper linkOsStatsMapper;

    @Mock
    private LinkDeviceStatsMapper linkDeviceStatsMapper;

    @Mock
    private LinkNetworkStatsMapper linkNetworkStatsMapper;

    @BeforeEach
    void setUp() {
        // Set up UserContext with a test username
        UserContext.setUsername("testuser");
    }

    @AfterEach
    void tearDown() {
        // Clear UserContext after each test
        UserContext.clear();
    }

    @Test
    void testOneShortLinkStats_WithValidData_ReturnsStats() {
        // Arrange
        ShortLinkStatsReqDTO requestParam = new ShortLinkStatsReqDTO();
        requestParam.setGid("test-gid");
        requestParam.setFullShortUrl("http://short.link/test");
        requestParam.setStartDate("2023-01-01");
        requestParam.setEndDate("2023-01-31");

        // Mock group check
        GroupDO groupDO = new GroupDO();
        groupDO.setGid("test-gid");
        groupDO.setUsername("testuser");
        when(linkGroupMapper.selectList(any())).thenReturn(Collections.singletonList(groupDO));

        // Mock basic stats
        LinkAccessStatsDO basicStats = new LinkAccessStatsDO();
        basicStats.setPv(100);
        basicStats.setUv(50);
        basicStats.setUip(30);
        when(linkAccessLogsMapper.findPvUvUidStatsByShortLink(requestParam)).thenReturn(basicStats);

        // Mock daily stats
        List<LinkAccessStatsDO> dailyStatsList = new ArrayList<>();
        LinkAccessStatsDO dailyStats1 = new LinkAccessStatsDO();
        dailyStats1.setDate(Date.valueOf("2023-01-01"));
        dailyStats1.setPv(10);
        dailyStats1.setUv(5);
        dailyStats1.setUip(3);
        dailyStatsList.add(dailyStats1);

        LinkAccessStatsDO dailyStats2 = new LinkAccessStatsDO();
        dailyStats2.setDate(Date.valueOf("2023-01-02"));
        dailyStats2.setPv(20);
        dailyStats2.setUv(10);
        dailyStats2.setUip(6);
        dailyStatsList.add(dailyStats2);

        when(linkAccessStatsMapper.listStatsByShortLink(requestParam)).thenReturn(dailyStatsList);

        // Mock locale stats
        List<LinkLocaleStatsDO> localeStatsList = new ArrayList<>();
        LinkLocaleStatsDO localeStats1 = new LinkLocaleStatsDO();
        localeStats1.setProvince("北京");
        localeStats1.setCnt(20);
        localeStatsList.add(localeStats1);

        LinkLocaleStatsDO localeStats2 = new LinkLocaleStatsDO();
        localeStats2.setProvince("上海");
        localeStats2.setCnt(15);
        localeStatsList.add(localeStats2);

        when(linkLocaleStatsMapper.listLocaleByShortLink(requestParam)).thenReturn(localeStatsList);

        // Mock hour stats
        List<LinkAccessStatsDO> hourStatsList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            LinkAccessStatsDO hourStats = new LinkAccessStatsDO();
            hourStats.setHour(i);
            hourStats.setPv(i * 2);
            hourStatsList.add(hourStats);
        }
        when(linkAccessStatsMapper.listHourStatsByShortLink(requestParam)).thenReturn(hourStatsList);

        // Mock top IP stats
        List<HashMap<String, Object>> topIpStatsList = new ArrayList<>();
        HashMap<String, Object> topIp1 = new HashMap<>();
        topIp1.put("ip", "192.168.1.1");
        topIp1.put("count", 5);
        topIpStatsList.add(topIp1);

        HashMap<String, Object> topIp2 = new HashMap<>();
        topIp2.put("ip", "192.168.1.2");
        topIp2.put("count", 3);
        topIpStatsList.add(topIp2);

        when(linkAccessLogsMapper.listTopIpByShortLink(requestParam)).thenReturn(topIpStatsList);

        // Mock weekday stats
        List<LinkAccessStatsDO> weekdayStatsList = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            LinkAccessStatsDO weekdayStats = new LinkAccessStatsDO();
            weekdayStats.setWeekday(i);
            weekdayStats.setPv(i * 5);
            weekdayStatsList.add(weekdayStats);
        }
        when(linkAccessStatsMapper.listWeekdayStatsByShortLink(requestParam)).thenReturn(weekdayStatsList);

        // Mock browser stats
        List<HashMap<String, Object>> browserStatsList = new ArrayList<>();
        HashMap<String, Object> browser1 = new HashMap<>();
        browser1.put("browser", "Chrome");
        browser1.put("count", 40);
        browserStatsList.add(browser1);

        HashMap<String, Object> browser2 = new HashMap<>();
        browser2.put("browser", "Firefox");
        browser2.put("count", 25);
        browserStatsList.add(browser2);

        when(linkBrowserStatsMapper.listBrowserStatsByShortLink(requestParam)).thenReturn(browserStatsList);

        // Mock OS stats
        List<HashMap<String, Object>> osStatsList = new ArrayList<>();
        HashMap<String, Object> os1 = new HashMap<>();
        os1.put("os", "Windows");
        os1.put("count", 50);
        osStatsList.add(os1);

        HashMap<String, Object> os2 = new HashMap<>();
        os2.put("os", "MacOS");
        os2.put("count", 30);
        osStatsList.add(os2);

        when(linkOsStatsMapper.listOsStatsByShortLink(requestParam)).thenReturn(osStatsList);

        // Mock UV type stats
        HashMap<String, Object> uvTypeStats = new HashMap<>();
        uvTypeStats.put("oldUserCnt", 30);
        uvTypeStats.put("newUserCnt", 20);
        when(linkAccessLogsMapper.findUvTypeCntByShortLink(requestParam)).thenReturn(uvTypeStats);

        // Mock device stats
        List<LinkDeviceStatsDO> deviceStatsList = new ArrayList<>();
        LinkDeviceStatsDO device1 = new LinkDeviceStatsDO();
        device1.setDevice("Desktop");
        device1.setCnt(40);
        deviceStatsList.add(device1);

        LinkDeviceStatsDO device2 = new LinkDeviceStatsDO();
        device2.setDevice("Mobile");
        device2.setCnt(35);
        deviceStatsList.add(device2);

        when(linkDeviceStatsMapper.listDeviceStatsByShortLink(requestParam)).thenReturn(deviceStatsList);

        // Mock network stats
        List<LinkNetworkStatsDO> networkStatsList = new ArrayList<>();
        LinkNetworkStatsDO network1 = new LinkNetworkStatsDO();
        network1.setNetwork("WiFi");
        network1.setCnt(60);
        networkStatsList.add(network1);

        LinkNetworkStatsDO network2 = new LinkNetworkStatsDO();
        network2.setNetwork("4G");
        network2.setCnt(25);
        networkStatsList.add(network2);

        when(linkNetworkStatsMapper.listNetworkStatsByShortLink(requestParam)).thenReturn(networkStatsList);

        // Act
        ShortLinkStatsRespDTO result = shortLinkStatsService.oneShortLinkStats(requestParam);

        // Assert
        assertNotNull(result);
        assertEquals(100, result.getPv());
        assertEquals(50, result.getUv());
        assertEquals(30, result.getUip());

        // Check daily stats
        List<ShortLinkStatsAccessDailyRespDTO> daily = result.getDaily();
        assertNotNull(daily);
        assertEquals(31, daily.size()); // January has 31 days

        // Check first day
        ShortLinkStatsAccessDailyRespDTO day1 = daily.get(0);
        assertEquals("2023-01-01", day1.getDate());
        assertEquals(10, day1.getPv());
        assertEquals(5, day1.getUv());
        assertEquals(3, day1.getUip());

        // Check second day
        ShortLinkStatsAccessDailyRespDTO day2 = daily.get(1);
        assertEquals("2023-01-02", day2.getDate());
        assertEquals(20, day2.getPv());
        assertEquals(10, day2.getUv());
        assertEquals(6, day2.getUip());

        // Check locale stats
        List<ShortLinkStatsLocaleCNRespDTO> localeCnStats = result.getLocaleCnStats();
        assertNotNull(localeCnStats);
        assertEquals(2, localeCnStats.size());

        // Check first locale
        ShortLinkStatsLocaleCNRespDTO locale1 = localeCnStats.get(0);
        assertEquals("北京", locale1.getLocale());
        assertEquals(20, locale1.getCnt());
        assertEquals(0.57, locale1.getRatio(), 0.01); // 20 / 35 ≈ 0.57

        // Check second locale
        ShortLinkStatsLocaleCNRespDTO locale2 = localeCnStats.get(1);
        assertEquals("上海", locale2.getLocale());
        assertEquals(15, locale2.getCnt());
        assertEquals(0.43, locale2.getRatio(), 0.01); // 15 / 35 ≈ 0.43

        // Check hour stats
        List<Integer> hourStats = result.getHourStats();
        assertNotNull(hourStats);
        assertEquals(24, hourStats.size());

        for (int i = 0; i < 24; i++) {
            assertEquals(i * 2, hourStats.get(i));
        }

        // Check top IP stats
        List<ShortLinkStatsTopIpRespDTO> topIpStats = result.getTopIpStats();
        assertNotNull(topIpStats);
        assertEquals(2, topIpStats.size());

        // Check first IP
        ShortLinkStatsTopIpRespDTO ip1 = topIpStats.get(0);
        assertEquals("192.168.1.1", ip1.getIp());
        assertEquals(5, ip1.getCnt());

        // Check second IP
        ShortLinkStatsTopIpRespDTO ip2 = topIpStats.get(1);
        assertEquals("192.168.1.2", ip2.getIp());
        assertEquals(3, ip2.getCnt());

        // Check weekday stats
        List<Integer> weekdayStats = result.getWeekdayStats();
        assertNotNull(weekdayStats);
        assertEquals(7, weekdayStats.size());

        for (int i = 0; i < 7; i++) {
            assertEquals((i + 1) * 5, weekdayStats.get(i));
        }

        // Check browser stats
        List<ShortLinkStatsBrowserRespDTO> browserStats = result.getBrowserStats();
        assertNotNull(browserStats);
        assertEquals(2, browserStats.size());

        // Check first browser
        ShortLinkStatsBrowserRespDTO browserResp1 = browserStats.get(0);
        assertEquals("Chrome", browserResp1.getBrowser());
        assertEquals(40, browserResp1.getCnt());
        assertEquals(0.62, browserResp1.getRatio(), 0.01); // 40 / 65 ≈ 0.62

        // Check second browser
        ShortLinkStatsBrowserRespDTO browserResp2 = browserStats.get(1);
        assertEquals("Firefox", browserResp2.getBrowser());
        assertEquals(25, browserResp2.getCnt());
        assertEquals(0.38, browserResp2.getRatio(), 0.01); // 25 / 65 ≈ 0.38

        // Check OS stats
        List<ShortLinkStatsOsRespDTO> osStats = result.getOsStats();
        assertNotNull(osStats);
        assertEquals(2, osStats.size());

        // Check first OS
        ShortLinkStatsOsRespDTO osResp1 = osStats.get(0);
        assertEquals("Windows", osResp1.getOs());
        assertEquals(50, osResp1.getCnt());
        assertEquals(0.625, osResp1.getRatio(), 0.01); // 50 / 80 = 0.625

        // Check second OS
        ShortLinkStatsOsRespDTO osResp2 = osStats.get(1);
        assertEquals("MacOS", osResp2.getOs());
        assertEquals(30, osResp2.getCnt());
        assertEquals(0.375, osResp2.getRatio(), 0.01); // 30 / 80 = 0.375

        // Check UV type stats
        List<ShortLinkStatsUvRespDTO> uvTypeStatsResp = result.getUvTypeStats();
        assertNotNull(uvTypeStatsResp);
        assertEquals(2, uvTypeStatsResp.size());

        // Check new user
        ShortLinkStatsUvRespDTO newUser = uvTypeStatsResp.stream()
                .filter(uv -> "newUser".equals(uv.getUvType()))
                .findFirst()
                .orElse(null);
        assertNotNull(newUser);
        assertEquals(20, newUser.getCnt());
        assertEquals(0.4, newUser.getRatio(), 0.01); // 20 / 50 = 0.4

        // Check old user
        ShortLinkStatsUvRespDTO oldUser = uvTypeStatsResp.stream()
                .filter(uv -> "oldUser".equals(uv.getUvType()))
                .findFirst()
                .orElse(null);
        assertNotNull(oldUser);
        assertEquals(30, oldUser.getCnt());
        assertEquals(0.6, oldUser.getRatio(), 0.01); // 30 / 50 = 0.6

        // Check device stats
        List<ShortLinkStatsDeviceRespDTO> deviceStats = result.getDeviceStats();
        assertNotNull(deviceStats);
        assertEquals(2, deviceStats.size());

        // Check desktop
        ShortLinkStatsDeviceRespDTO desktop = deviceStats.stream()
                .filter(d -> "Desktop".equals(d.getDevice()))
                .findFirst()
                .orElse(null);
        assertNotNull(desktop);
        assertEquals(40, desktop.getCnt());
        assertEquals(0.53, desktop.getRatio(), 0.01); // 40 / 75 ≈ 0.53

        // Check mobile
        ShortLinkStatsDeviceRespDTO mobile = deviceStats.stream()
                .filter(d -> "Mobile".equals(d.getDevice()))
                .findFirst()
                .orElse(null);
        assertNotNull(mobile);
        assertEquals(35, mobile.getCnt());
        assertEquals(0.47, mobile.getRatio(), 0.01); // 35 / 75 ≈ 0.47

        // Check network stats
        List<ShortLinkStatsNetworkRespDTO> networkStats = result.getNetworkStats();
        assertNotNull(networkStats);
        assertEquals(2, networkStats.size());

        // Check WiFi
        ShortLinkStatsNetworkRespDTO wifi = networkStats.stream()
                .filter(n -> "WiFi".equals(n.getNetwork()))
                .findFirst()
                .orElse(null);
        assertNotNull(wifi);
        assertEquals(60, wifi.getCnt());
        assertEquals(0.7059, wifi.getRatio(), 0.01); // 60 / 85 ≈ 0.7059

        // Check 4G
        ShortLinkStatsNetworkRespDTO fourG = networkStats.stream()
                .filter(n -> "4G".equals(n.getNetwork()))
                .findFirst()
                .orElse(null);
        assertNotNull(fourG);
        assertEquals(25, fourG.getCnt());
        assertEquals(0.2941, fourG.getRatio(), 0.01); // 25 / 85 ≈ 0.2941

        // Verify all mocks were called
        verify(linkGroupMapper, times(1)).selectList(any());
        verify(linkAccessStatsMapper, times(1)).listStatsByShortLink(requestParam);
        verify(linkAccessLogsMapper, times(1)).findPvUvUidStatsByShortLink(requestParam);
        verify(linkLocaleStatsMapper, times(1)).listLocaleByShortLink(requestParam);
        verify(linkAccessStatsMapper, times(1)).listHourStatsByShortLink(requestParam);
        verify(linkAccessLogsMapper, times(1)).listTopIpByShortLink(requestParam);
        verify(linkAccessStatsMapper, times(1)).listWeekdayStatsByShortLink(requestParam);
        verify(linkBrowserStatsMapper, times(1)).listBrowserStatsByShortLink(requestParam);
        verify(linkOsStatsMapper, times(1)).listOsStatsByShortLink(requestParam);
        verify(linkAccessLogsMapper, times(1)).findUvTypeCntByShortLink(requestParam);
        verify(linkDeviceStatsMapper, times(1)).listDeviceStatsByShortLink(requestParam);
        verify(linkNetworkStatsMapper, times(1)).listNetworkStatsByShortLink(requestParam);
    }

    @Test
    void testOneShortLinkStats_WithEmptyData_ReturnsNull() {
        // Arrange
        ShortLinkStatsReqDTO requestParam = new ShortLinkStatsReqDTO();
        requestParam.setGid("test-gid");
        requestParam.setFullShortUrl("http://short.link/test");
        requestParam.setStartDate("2023-01-01");
        requestParam.setEndDate("2023-01-31");

        // Mock group check
        GroupDO groupDO = new GroupDO();
        groupDO.setGid("test-gid");
        groupDO.setUsername("testuser");
        when(linkGroupMapper.selectList(any())).thenReturn(Collections.singletonList(groupDO));

        // Mock empty stats
        when(linkAccessStatsMapper.listStatsByShortLink(requestParam)).thenReturn(Collections.emptyList());

        // Act
        ShortLinkStatsRespDTO result = shortLinkStatsService.oneShortLinkStats(requestParam);

        // Assert
        assertNull(result);

        // Verify mocks
        verify(linkGroupMapper, times(1)).selectList(any());
        verify(linkAccessStatsMapper, times(1)).listStatsByShortLink(requestParam);
        verify(linkAccessLogsMapper, never()).findPvUvUidStatsByShortLink(any());
        verify(linkLocaleStatsMapper, never()).listLocaleByShortLink(any());
        verify(linkAccessStatsMapper, never()).listHourStatsByShortLink(any());
        verify(linkAccessLogsMapper, never()).listTopIpByShortLink(any());
        verify(linkAccessStatsMapper, never()).listWeekdayStatsByShortLink(any());
        verify(linkBrowserStatsMapper, never()).listBrowserStatsByShortLink(any());
        verify(linkOsStatsMapper, never()).listOsStatsByShortLink(any());
        verify(linkAccessLogsMapper, never()).findUvTypeCntByShortLink(any());
        verify(linkDeviceStatsMapper, never()).listDeviceStatsByShortLink(any());
        verify(linkNetworkStatsMapper, never()).listNetworkStatsByShortLink(any());
    }

    @Test
    void testOneShortLinkStats_WithGroupNotBelongingToUser_ThrowsServiceException() {
        // Arrange
        ShortLinkStatsReqDTO requestParam = new ShortLinkStatsReqDTO();
        requestParam.setGid("test-gid");
        requestParam.setFullShortUrl("http://short.link/test");
        requestParam.setStartDate("2023-01-01");
        requestParam.setEndDate("2023-01-31");

        // Mock group check - group doesn't belong to user
        when(linkGroupMapper.selectList(any())).thenReturn(Collections.emptyList());

        // Act & Assert
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            shortLinkStatsService.oneShortLinkStats(requestParam);
        });

        assertEquals("用户信息与分组标识不匹配", exception.getMessage());

        // Verify mocks
        verify(linkGroupMapper, times(1)).selectList(any());
        verify(linkAccessStatsMapper, never()).listStatsByShortLink(any());
    }

    @Test
    void testOneShortLinkStats_WithNoUserLoggedIn_ThrowsServiceException() {
        // Arrange
        ShortLinkStatsReqDTO requestParam = new ShortLinkStatsReqDTO();
        requestParam.setGid("test-gid");
        requestParam.setFullShortUrl("http://short.link/test");
        requestParam.setStartDate("2023-01-01");
        requestParam.setEndDate("2023-01-31");

        // Clear UserContext
        UserContext.clear();

        // Act & Assert
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            shortLinkStatsService.oneShortLinkStats(requestParam);
        });

        assertEquals("用户未登录", exception.getMessage());

        // Verify mocks
        verify(linkGroupMapper, never()).selectList(any());
        verify(linkAccessStatsMapper, never()).listStatsByShortLink(any());
    }
}